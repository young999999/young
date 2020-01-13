<template>
	<view>
		<!-- 导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="true">
			<block slot="content">导航栏</block>
		</cu-custom>


		<view @click="chooseImage">+ 选择图片</view>



		<image class="img" v-if="imageSrc" :src="imageSrc" mode="center" />
		<block v-else>
			<view class="uni-hello-text">
				点击按钮下载服务端示例图片（下载网络文件到本地临时目录）
			</view>
			<view class="uni-btn-v">
				<button type="primary" @tap="downloadImage">下载</button>
			</view>
		</block>
		<view>{{title}}</view>



	</view>

</template>
<script>
	export default {
		data() {
			return {
				title: '',
				imageSrc: ''
			}
		},
		onUnload() {
			this.imageSrc = '';
		},
		methods: {
			chooseImage: function() {
				uni.chooseImage({ //从本地文件夹选择图片
					count: 2, //最多可以选择的图片张数，默认9
					/* Array<String>，original 原图，compressed 压缩图，默认二者都有 */
					sizeType: ['compressed'],
					/* Array<String>，album 从相册选图，camera 使用相机，默认二者都有。如需直接开相机或直接选相册，只使用一个选项	 */
					sourceType: ['album'],
					success: function(res) {
						var tempFilePaths = res.tempFilePaths;
						console.log("uni.chooseImage");
						console.log(tempFilePaths);
						uni.saveFile({
							tempFilePath: tempFilePaths[0], //0代表第一张图片
							success: function(res) {
								var savedFilePath = res.savedFilePath;
								console.log("uni.saveFile");
								console.log(savedFilePath);
								uni.uploadFile({
									url: 'https://www.example.com/upload', //仅为示例，非真实的接口地址
									filePath: tempFilePaths[0],
									name: 'file',
									formData: {
										'user': 'test'
									},
									success: (uploadFileRes) => {
										console.log(uploadFileRes.data);
									}
								});
							}
						});
					}
				});
			},

			downloadImage: function() {
				uni.showLoading({
					title: '下载中'
				})
				var self = this
				uni.downloadFile({ /* 从服务器下载文件*/
					// url: "http://47.98.53.232:8087/logo.png",
					// url: "http://192.168.1.111:8087/logo.png",
					url: "http://localhost:8087/logo.png",
					success: (res) => {
						console.log('downloadFile success, res is', res)
						self.imageSrc = res.tempFilePath;
						uni.hideLoading();
						
						uni.saveImageToPhotosAlbum({ /* 保存图片（视频也可以）到本地路径 */
							filePath: self.imageSrc,
							success: function() {
								self.title = "success";
								console.log('save success');
							},
							fail: (err) =>{
								self.title = "saveerr";
								console.log('saveFile fail, err is:', err)
							}
						});
					},
					fail: (err) => {
						uni.hideLoading();
						
						self.title = "downerr";
						console.log('downloadFile fail, err is:', err)
					}
				})
			},
		}
	}
</script>

<style>
	.demo {
		background: #FFF;
	}
</style>
