package com.binarybricks.coinbit.features.coindetails

import com.binarybricks.coinbit.data.database.CoinBitDatabase
import com.binarybricks.coinbit.data.database.entities.WatchedCoin
import com.binarybricks.coinbit.network.schedulers.RxSchedulers
import io.reactivex.Single

/**
Created by Pranay Airan
 * Repository that interact with crypto api and database for getting data.
 */

class CoinDetailsPagerRepository(
    private val rxSchedulers: RxSchedulers,
    private val coinBitDatabase: CoinBitDatabase?
) {

    /**
     * Get list of all coins that is added in watch list
     */
    fun loadWatchedCoins(): Single<List<WatchedCoin>>? {

        coinBitDatabase?.let {
            return it.watchedCoinDao().getAllWatchedCoinsOnetime().subscribeOn(rxSchedulers.io())
        }
        return null
    }
}