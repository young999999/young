<template>
	<view >
		
		<!-- 导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="false">
			<block slot="content">首页</block>
			<block slot="backText">返回</block>
		</cu-custom>
		
		<!-- 搜索组件search -->
		<search ></search>
		
		<!-- 图片轮播  -->
		<pictureSwiper style="margin: 0 20rpx 0 20rpx;"></pictureSwiper>
	</view>
</template>

<script>
	import search from "../../components/search"
	import pictureSwiper from "../../components/pictureSwiper.vue"
	export default {
		data() {
			return {
				
			}
		},
		components:{
			search,
			pictureSwiper
		},
		onShow() {
			
			/* 判断是否登陆 */
			var res=global.isLogin();
			if(!res){
				uni.showModal({
					title:'提醒',
					content:'请登录',
					success() {
						uni.navigateTo({
							url:"../login/login"
						})
					}
				})
			}
		},
		methods: {

		}
	}
</script>

<style scoped>


</style>
