<template>
	<view>
		<!-- 		导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="true">
			<block slot="content">{{movieName}}</block>
			<block slot="backText">返回</block>
		</cu-custom>


		<!-- 搜索框 -->
		<view class="cu-bar search bg-white">
			<view class="search-form round">
				<text class="cuIcon-search"></text>
				<!-- @blur 是当元素失去焦点时所触发的事件
					 @focus当元素获得焦点时,发生focus事件 -->
				<input @blur="InputBlur" :adjust-position="false" type="text" placeholder="请输入电影或电视剧名称" confirm-type="search"></input>
			</view>
			<view class="action">
				<button class="cu-btn bg-green shadow-blur round" @click="searchVideo">搜索</button>
			</view>

		</view>


		<view v-if="judge" class="text-red text-xl">{{judge}}</view>
		<view v-else v-for="(item ,index) of movieCollection" :key="index">

			<button v-if="movieCollection.length<2" @click="gotoVideo(item,0)">{{movieName}}</button>
			<button v-else @click="gotoVideo(item,1)">第{{index+1}}集</button><br>

		</view>











	</view>
</template>

<script>
	export default {
		data() {
			return {
				judge: "",//判断查询内容是否存在
				InputBottom: "坏爱情",
				movieName: "",
				movieCategory: "",
				movieUrl: "",
				movieCollection: []
			};
		},
		onShow() {


		},
		methods: {
			InputBlur(e) {
				//console.log(e.detail.value);//e.detail.value=在输入框失去焦点时输入框中的值
				this.InputBottom = e.detail.value;


			},

			gotoVideo(data, Category) {
				/*  Category等于0表示是电影，Category等于1表示是电视剧*/
				uni.navigateTo({
					url: "../../components/video?movieData=" + data + "&Category=" + Category + "&name=" + this.movieName
					// url: "../../components/video?movieUrl=" + this.movieUrl + "&movieName=" + this.movieName
				})
			},
			searchVideo() {
				uni.request({
					url: 'http://192.168.1.111:8087/movie/' + this.InputBottom, //仅为示例，并非真实接口地址。

					method: 'GET',
					success: (res) => {

						if (res.data == "") {

							this.judge = "查询内容不存在";

						} else {
						
							this.judge = "";
							// console.log(res.data);
							this.movieName = res.data.movieName;
							// console.log(res.data.movieName);

							this.movieCategory = res.data.movieCategory;
							// console.log(res.data.movieCategory);

							var mc = res.data.movieCollection.toString();
							var l = mc.split(",");
							console.log(l);
							this.movieCollection = l;
						}






					}
				});
			},
		}
	}
</script>

<style scoped>

</style>
