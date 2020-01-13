<template>
	<view>

		<!-- 导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="false">
			<block slot="content">首页</block>
		</cu-custom>

		<!-- 搜索框 -->
		<view class="cu-bar search bg-white">
			<view class="search-form round">
				<text class="cuIcon-search"></text>
				<input v-model="InputBottom" @focus="InputFocus" @blur="InputBlur" :adjust-position="false" type="text" placeholder="搜索图片、文章、视频"
				 confirm-type="search"></input>
			</view>
			<view class="action">
				<button class="cu-btn bg-green shadow-blur round">搜索</button>
			</view>

		</view>



		<image src="http://47.98.53.232:8087/logo.png"></image><br>
<!-- 		<image src="http://img2.imgtn.bdimg.com/it/u=2462146637,4274174245&fm=26&gp=0.jpg"></image><br> -->
		<button class="cu-btn round bg-green " @click="tolinked">联动</button>
		<button class="cu-btn round bg-green shadow  lg">
			<uni-text v-if="true" class="cuIcon-loading2 cuIconfont-spin"><span></span></uni-text>
			加载
		</button>


		<test :msg="msg" @testShowName="testEvent()"></test>
		
		
		<view class="cu-bar tabbar margin-bottom-xl bg-black">
			<view class="action text-green">
				<view class="cuIcon-homefill"></view> 首页
			</view>
			<view class="action text-gray">
				<view class="cuIcon-similar"></view> 分类
			</view>
			<view class="action text-gray add-action">
				<button class="cu-btn cuIcon-add bg-green shadow"></button>
				发布
			</view>
			<view class="action text-gray">
				<view class="cuIcon-cart">
					<view class="cu-tag badge">99</view>
				</view>
				购物车
			</view>
			<view class="action text-gray">
				<view class="cuIcon-my">
					<view class="cu-tag badge"></view>
				</view>
				我的
			</view>
		</view>
		
	</view>

</template>

<script>
	import test from "../../components/test.vue"
	import music from "../../components/linked.vue"
	export default {
		data() {
			return {
				msg: 'young',
				InputBottom: '',//双向绑定（v-model）搜索框输入的内容
			}
		},
		components: {
			test,
			music
		},
		onLoad() {
			uni.$on("testEmit", (rel) => {/* 搭配test组件中的uni.$emit("testEmit", {name: "zj"}) */
				console.log(rel);
			})
		},
		onShareAppMessage() {
			console.log("用户分享了页面");
			return {
				title: "NBA",
				path: "page/news/news",
				imageUrl: "http://img12.3lian.com/gaoqing02/02/93/37.jpg"
			}
		},
		methods: {
			testEvent(data) {/* // 搭配test组件中的this.$emit('testShowName',{name:"young"}) */
				console.log(data);
			},
			tolinked() {
				uni.navigateTo({

					url: '../../components/linked'
				});
			},
			InputFocus(e) {
				//输入框得到焦点
			},
			InputBlur(e) {
				console.log(this.InputBottom);
				//console.log(e.detail.value);//e.detail.value=在输入框失去焦点时输入框中的值
			}
		}
	}
</script>

<style scoped>

</style>
