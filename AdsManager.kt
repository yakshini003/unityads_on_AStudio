package com.example.mummy
import android.app.Activity
import android.widget.RelativeLayout
import android.widget.Toast
import com.unity3d.ads.IUnityAdsInitializationListener
import com.unity3d.ads.IUnityAdsShowListener
import com.unity3d.ads.UnityAds
import com.unity3d.ads.UnityAdsShowOptions
import com.unity3d.services.banners.BannerErrorInfo
import com.unity3d.services.banners.BannerView
import com.unity3d.services.banners.UnityBannerSize

class AdsManager (private val activity: Activity) :
    IUnityAdsInitializationListener {

    companion object {
        private const val GAME_ID = "5109386"
        private const val BANNER_ID = "Banner_Android"
        private const val INTERSTITIAL_ID = "Interstitial_Android"
        private const val REWARD_ID = "Rewarded_Android"
        private const val TEST_MODE = true

    }

    private fun showToast(msg: String){
        Toast.makeText(activity.applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    fun initialize(){
        UnityAds.initialize(
            activity.applicationContext,
            GAME_ID,
            TEST_MODE,
            this
        )
        showToast( "init ads")
    }

    fun showBanner(bannerLayout: RelativeLayout){
        val bannerView = BannerView(
            activity,
            BANNER_ID,
            UnityBannerSize(320, 50)
        )
        bannerView.listener = UnityAdsBannerListener()
        bannerView.load()
        bannerLayout.addView(bannerView)
        showToast( "request banner")
    }

    fun showInterstitial(){
        UnityAds.show(
            activity,
            INTERSTITIAL_ID,
            UnityAdsShowOptions(),
            UnityAdsShowListener()
        )
        showToast( "request interstitial")
    }

    fun showReward(){
        UnityAds.show(
            activity,
            REWARD_ID,
            UnityAdsShowOptions(),
            UnityAdsShowListener()
        )
        showToast( "request reward")
    }

    class UnityAdsBannerListener : BannerView.IListener {
        override fun onBannerLoaded(p0: BannerView?) {

        }

        override fun onBannerClick(p0: BannerView?) {

        }

        override fun onBannerFailedToLoad(p0: BannerView?, p1: BannerErrorInfo?) {

        }

        override fun onBannerLeftApplication(p0: BannerView?) {

        }

    }

    class UnityAdsShowListener : IUnityAdsShowListener {
        override fun onUnityAdsShowFailure(
            p0: String?,
            p1: UnityAds.UnityAdsShowError?,
            p2: String?
        ) {

        }

        override fun onUnityAdsShowStart(p0: String?) {

        }

        override fun onUnityAdsShowClick(p0: String?) {

        }

        override fun onUnityAdsShowComplete(
            p0: String?,
            p1: UnityAds.UnityAdsShowCompletionState?
        ) {
            
        }


    }

    override fun onInitializationComplete() {
        showToast( "init complete")
    }

    override fun onInitializationFailed(p0: UnityAds.UnityAdsInitializationError?, p1: String?) {
        showToast("init failed, re init..")
        initialize()
    }

}
