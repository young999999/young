<template>
	<view>
		
		<cu-custom bgColor="bg-gradual-pink" :isBack="true">
			<block slot="content">视频页</block>
			<block slot="backText">返回</block>
		</cu-custom>
		
		<view class="uni-padding-wrap uni-common-mt">
			<view>
				<video id="myVideo" src="http://qukufile2.qianqian.com/data2/video/a6cdfce4be66a78d8a50edff7786ff20/673400038/673400038.mp4"
				 @error="videoErrorCallback" :danmu-list="danmuList" enable-danmu danmu-btn controls custom-cache="false"></video>
			</view>
			<!-- <view>
				<video id="myVideo" src="http://192.168.1.111:8087/makeyoumine.mp4"
				 @error="videoErrorCallback" :danmu-list="danmuList" enable-danmu danmu-btn controls></video>
			</view> -->
			
			<!-- #ifndef MP-ALIPAY --><!-- 不在支付宝小程序出现 -->
			<view class="uni-list uni-common-mt">
				<view class="uni-list-cell">
					<view>
						<view class="uni-label">弹幕内容</view>
					</view>
					<view class="uni-list-cell-db">
						<input v-model="danmuValue" class="uni-input" type="text" placeholder="在此处输入弹幕内容" />
					</view>
				</view>
			</view>
			<view class="uni-btn-v">
				<button @click="sendDanmu" class="page-body-button">发送弹幕</button>
			</view>
			<!-- #endif -->
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				src: '',
				danmuList: [{
						text: '第 1s 出现的弹幕',
						color: '#ff0000',
						time: 1
					},
					{
						text: '第 2s 出现的弹幕',
						color: '#ff00ff',
						time: 2
					},
					{
						text: '第 3s 出现的弹幕',
						color: '#ff00ff',
						time: 3
					}
				],
				danmuValue: ''
			}
		},
		onReady: function(res) {
			// #ifndef MP-ALIPAY
			this.videoContext = uni.createVideoContext('myVideo')
			// #endif
		},
		methods: {
			sendDanmu: function(e) {
				console.log(e);
				this.videoContext.sendDanmu({
					text: this.danmuValue,
					color: this.getRandomColor()
				});
				this.danmuValue = '';
			},
			videoErrorCallback: function(e) {
				
				uni.showModal({
					content: e.target.errMsg,
					showCancel: false
				})
			},
			getRandomColor: function() {  /* 得到一个十六进制的随机颜色 */
				const rgb = []
				for (let i = 0; i < 3; ++i) {
					let color = Math.floor(Math.random() * 256).toString(16)
					color = color.length == 1 ? '0' + color : color
					rgb.push(color)
				}
				return '#' + rgb.join('')
			}
		}
	}
</script>

<style scoped>
	#myVideo{
		width: 100%;
	}
</style>
