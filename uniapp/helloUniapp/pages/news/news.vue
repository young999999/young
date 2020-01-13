<template>
	<view>
		<cu-custom bgColor="bg-gradual-pink" :isBack="false">
			<block slot="content">新闻页</block>

		</cu-custom>

		<!-- 图片轮播 -->
		<swiper class="screen-swiper round-dot" :indicator-dots="true" :circular="true" :autoplay="true" interval="2000"
		 duration="500">
			<swiper-item v-for="(item,index) in 4" :key="index">
				<image :src="'https://ossweb-img.qq.com/images/lol/web201310/skin/big3900'+index+ '.jpg'" mode="aspectFill"></image>
			</swiper-item>
		</swiper>

		<switch @change="SetShadow" :class="shadow?'checked':''" class="blue" style="transform:scale(1.0);"></switch><br>

		<button class="cu-btn round bg-green " @click="tovideo">video</button>
		<button class="cu-btn round bg-green " @click="tomusic">music</button>
		<icon type="success" size="26" />


	</view>
</template>

<script>
	export default {
		data() {
			return {
				dotStyle: false,
				shadow: false,


			}
		},
		methods: {
			SetShadow(e) {
				this.shadow = e.detail.value
			},

			tovideo() {
				uni.navigateTo({
					url: '../../components/video'
				});
			},
			tomusic() {
				uni.navigateTo({
					url: '../../components/music'
				});
			},
		}
	}
</script>

<style scoped>

</style>
