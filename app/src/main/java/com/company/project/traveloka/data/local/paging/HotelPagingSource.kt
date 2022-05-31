package com.company.project.traveloka.data.local.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.remote.source.service.HotelApiService
import com.company.project.traveloka.utils.constant.HOTEL_API_STARTING_INDEX
import com.company.project.traveloka.utils.constant.NETWORK_LOAD_SIZE
import okio.IOException
import retrofit2.HttpException

class HotelPagingSource(private val apiService: HotelApiService) :
    PagingSource<Int, Hotel>() {

    override fun getRefreshKey(state: PagingState<Int, Hotel>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hotel> {
        return try {
            val position = params.key ?: HOTEL_API_STARTING_INDEX
            val response = apiService.findAll(
                page = position,
                size = NETWORK_LOAD_SIZE,
            )

            val stories = response.data
            val nextKey = if (stories.isNullOrEmpty()) null else position + 1
            LoadResult.Page(
                data = stories.orEmpty(),
                prevKey = if (position == HOTEL_API_STARTING_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }
}
