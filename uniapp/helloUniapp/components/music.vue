<template>
	<view>
		<!-- 导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="true">
			<block slot="content">音乐</block>
			<block slot="backText">返回</block>
		</cu-custom>

		<view class="music">
			<view>{{audioCurrentTime}}s</view>
			<view class="progress-box">
				<progress :percent="percent" stroke-width="3" />{{audioDurationeString}}min
			</view>
			<view class="content">
				<image class="item" src="../static/music/play.png" @click="play"></image>
				<image class="item" src="../static/music/pause.png " @click="pause"></image>
				<image class="item" src="../static/music/stop.png" @click="stop"></image>
			</view>
		</view>
	</view>
</template>

<script>
	const innerAudioContext = uni.createInnerAudioContext();
	innerAudioContext.src = 'http://cdnringbd.shoujiduoduo.com/ringres/userv1/a48/339/65390339.aac';
	export default {
		data() {
			return {
				dotStyle: false,
				shadow: false,
				audioCurrentTime: "0",
				audioDurationeInt: "0",
				audioDurationeString: "0",
				percent: 0.0

			}
		},
		onReady() {
			setInterval(() => {



				this.audioCurrentTime = innerAudioContext.currentTime;


				this.percent = innerAudioContext.currentTime / innerAudioContext.duration * 100;
				// // this.percent=this.percent.toString();
				console.log(this.percent);


				this.audioCurrentTime = this.audioCurrentTime.toString().split(".")[0];

				this.audioDurationeString = innerAudioContext.duration / 60.0 + innerAudioContext.duration % 60 / 10.0;
				this.audioDurationeString = this.audioDurationeString.toString().substr(0, 3);


			}, 50);
		},
		methods: {
			SetShadow(e) {
				this.shadow = e.detail.value
			},

			play(e) {

				this.dotStyle = e.detail.value;

				// console.log(e);
				innerAudioContext.play()
				innerAudioContext.onError((res) => {
					console.log(res.errMsg);
					console.log(res.errCode);
				});
			},
			pause() {
				innerAudioContext.pause();
				innerAudioContext.onError((res) => {
					console.log(res.errMsg);
					console.log(res.errCode);
				});
			},
			stop() {
				innerAudioContext.stop();
				innerAudioContext.onError((res) => {
					console.log(res.errMsg);
					console.log(res.errCode);
				});
			},
		}
	}
</script>

<style scoped>
	.music {
		width: 100%;
		position: absolute;
		bottom: 0;
		white-space: nowrap;
	}

	.content {
		display: flex;
		justify-content: center;
		background-color: lightgrey;
		align-self: flex-end;
	}

	.item {
		width: 50px;
		height: 50px;
	}
</style>
