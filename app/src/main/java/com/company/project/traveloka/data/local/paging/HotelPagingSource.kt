package com.company.project.traveloka.data.local.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.company.project.traveloka.data.local.model.entitiy.hotel.Hotel
import com.company.project.traveloka.data.remote.source.service.HotelApiService
import com.company.project.traveloka.utils.constant.HOTEL_API_STARTING_INDEX
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
            val response = apiService.findAll()

            val hotels = response.data
            val nextKey = if (hotels.isNullOrEmpty()) null else position + 1
            LoadResult.Page(
                data = hotels.orEmpty(),
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
