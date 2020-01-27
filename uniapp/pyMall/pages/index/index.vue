<template>
	<view>

		<!-- 导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="false">
			<block slot="content">首页</block>
			<block slot="backText">返回</block>
		</cu-custom>

		
		<!-- 搜索组件search -->
		<search></search>

		<!-- 图片轮播  -->
		<!-- <pictureSwiper></pictureSwiper> -->
		<swiper class="screen-swiper round-dot" :indicator-dots="true" :circular="true" :autoplay="true" interval="2000"
		 duration="500">
			<swiper-item v-for="(item,index) in 3" :key="index">
				<!-- 				<image :src="'https://ossweb-img.qq.com/images/lol/web201310/skin/big3900'+index+ '.jpg'" mode="aspectFill"></image>
 -->
				<image :src="'../../static/swiper/swiper'+(index+1)+ '.png'" mode="aspectFill" style="padding: 10rpx 20rpx 20rpx 10rpx ;"></image>

			</swiper-item>
		</swiper>




		<!-- 类别导航 -->


		<!-- 广告 -->
		<view class="ad bg-white">
			<view class="ad-title text-red" style="padding-left: 35rpx;margin-bottom: 40rpx;">猜你喜欢</view>
			<view class="ad-content" >
				<image src="../../static/ad/ad1.jpg" style="width: 50%;height: 150rpx;padding: 0 20rpx 0 20rpx;border-radius: 300rpx;"></image>
				<image src="../../static/ad/ad2.jpg" style="width: 50%;height: 150rpx;padding: 0 20rpx 0 20rpx;border-radius: 300rpx;"></image>
			</view>
		</view>

		</image>

		<!-- 限时秒杀 -->
		<seckill></seckill>
		
	</view>
</template>

<script>
	import search from "../../components/search"
	import pictureSwiper from "../../components/pictureSwiper.vue"
	import seckill from "../../components/seckill.vue"
	export default {
		data() {
			return {

			}
		},
		components: {
			search,
			pictureSwiper,
			seckill
		},
		onLoad() {

			/* 判断是否登陆 */
			var res = global.isLogin();
			if (!res) {
				uni.showModal({
					title: '未登录提醒',
					content: '是否登录？',
					success(res) {
						if (res.confirm) {
							console.log("从index页面进入login页面");
							uni.navigateTo({
								url: "../login/login"
							})
						} else if (res.cancel) {
							console.log('用户点击取消登录');
						}
					}
				})
			};


		},
		methods: {

		}
	}
</script>

<style scoped>
	.ad {
		display: flex;
		flex-direction: column;
		margin: 10rpx;


	}

	.ad-content {
		display: flex;
		flex-direction: row;
	}
</style>
