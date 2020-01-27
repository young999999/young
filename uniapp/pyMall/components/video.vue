<template>
	<view>
		<!-- 		导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="true">
			<block slot="content">{{movieName}}{{movieNumber}}</block>
			<block slot="backText">返回</block>
		</cu-custom>


		<video class="mVideo" :src="movieUrl" controls></video>


	</view>
</template>

<script>
	export default {
		data() {
			return {

				movieName: "",
				movieUrl: "",
				movieCategory: "",
				movieNumber:"",
				movieData: ""

			};
		},
		onLoad: function(option) { //option为object类型，会序列化上个页面传递的参数

			this.movieData = option.movieData;
			console.log(this.movieData);
			
			this.movieName = option.name;

			
			this.movieCategory = option.Category;
			console.log(this.movieCategory);
			if(this.movieCategory==1){
				this.movieNumber = this.movieData.split("$")[0];
			}
			else this.movieNumber = ""

			this.movieUrl = this.movieData.split("$")[1];
			console.log(this.movieUrl); //打印出上个页面传递的参数。

		},
		onShow() {


		},
		methods: {}
	}
</script>

<style scoped>
	.mVideo {
		width: 100%;
	}
</style>
