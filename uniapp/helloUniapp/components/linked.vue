<template>
	<view>


		<!-- 导航 -->
		<cu-custom bgColor="bg-gradual-pink" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content">导航栏</block>
		</cu-custom>

		<view class="outer">
			<view class="head">
				<view class="head-container">
					<view class="head-item text-center" style="background-color: #007AFF;">点菜</view>
					<view class="head-item text-center" style="background-color: #ED1C24;">评价</view>
					<view class="head-item text-center" style="background-color: #39B54A;">商家</view>
				</view>
			</view>


			<!-- 联动效果-->
			<view class="linked">
				<view class="VerticalBox">


					<!-- 左边 -->
					<scroll-view class="VerticalNav nav" scroll-y scroll-with-animation :scroll-top="verticalNavTop" style="height:calc(100vh - 315upx)">
						<view class="cu-item" :class="index==tabCur?'text-green cur':''" v-for="(item,index) in list" :key="index" @tap="TabSelect"
						 :data-id="index">
							Tab-{{item.name}}
						</view>
					</scroll-view>

					<!-- 右边 -->
					<scroll-view class="VerticalMain" scroll-y scroll-with-animation style="height:calc(100vh - 315upx)"
					 :scroll-into-view="'main-'+mainCur" @scroll="VerticalMain">
						<view class="padding-top padding-lr" v-for="(item,index) in list" :key="index" :id="'main-'+index">
							<view class="cu-bar solid-bottom bg-white">
								<view class="action">
									<text class="cuIcon-title text-green"></text> Tab-{{item.name}}</view>
							</view>
							<view class="cu-list menu-avatar">
								<view class="cu-item cur">
									<view class="cu-avatar radius lg" style="background-image:url(https://ossweb-img.qq.com/images/lol/web201310/skin/big81020.jpg);">
										<view class="cu-tag badge"></view>
									</view>
									<view class="content">
										<view>
											<text class="text-cut">瓦罗兰大陆-睡衣守护者-新手保护营</text>
											<view class="cu-tag round bg-orange sm">6人</view>
										</view>
										<view class="text-gray text-sm flex">
											<text class="text-cut"> 伊泽瑞尔：<text class="cuIcon-locationfill text-orange margin-right-xs"></text> 传送中...</text></view>
									</view>
									<view class="action">
										<view class="text-grey text-xs">22:20</view>
										<view class="cuIcon-notice_forbid_fill text-gray"></view>
									</view>
								</view>
							</view>
						</view>
					</scroll-view>
				</view>
			</view>

			<view class="footer">
				<view class="cu-bar bg-white tabbar border shop">
					<button class="action" open-type="contact">
						<view class="cuIcon-service text-green">
							<view class="cu-tag badge"></view>
						</view>
						客服
					</button>
					<view class="action text-orange">
						<view class="cuIcon-favorfill"></view> 已收藏
					</view>
					<view class="action">
						<view class="cuIcon-cart">
							<view class="cu-tag badge">99</view>
						</view>
						购物车
					</view>
					<view class="bg-red submit">立即订购</view>
				</view>

			</view>
		</view>


	</view>
</template>

<script scoped>
var id={id:109};
	export default {
		data() {
			return {
				list: [],
				tabCur: 0,
				mainCur: 0,
				verticalNavTop: 0,
				load: true
			};
		},

		onLoad() {
			
			
			
			
			uni.showLoading({
				title: '加载中...',
				mask: true
			});
			let list = [{}];
			for (let i = 0; i < 26; i++) {
				list[i] = {};
				list[i].name = String.fromCharCode(65 + i);
				list[i].id = i;
			}
			this.list = list;
			this.listCur = list[0];
		},
		
		
		onReady() {
			uni.hideLoading();
			uni.request({
			    url: 'http://m.leqiuba8.com/e/extend/list/list.php', //仅为示例，并非真实接口地址。
			 //    data: {
			 //        id:109,
				// 	name:'zj'
				// 	// title:'py',
				// 	// mdContent:'zj'
					
			 //    },
				
			 //    header: {
			 //        'content-type': 'application/json' //自定义请求头信息
			 //    },
				method:'GET',
				// method:'POST',
				
			    success: (res) => {
					console.log(res.data);
			  //       console.log(res.data.title);
					// console.log(res.statusCode);
			       
			    },
			});
		},
		methods: {


			TabSelect(e) {
				this.tabCur = e.currentTarget.dataset.id;
				this.mainCur = e.currentTarget.dataset.id;
				this.verticalNavTop = (e.currentTarget.dataset.id - 1) * 50
			},
			VerticalMain(e) {
				// #ifdef MP-ALIPAY
				return false //支付宝小程序暂时不支持双向联动 
				// #endif
				let that = this;
				let tabHeight = 0;
				if (this.load) {
					for (let i = 0; i < this.list.length; i++) {
						let view = uni.createSelectorQuery().select("#main-" + this.list[i].id);
						view.fields({
							size: true
						}, data => {
							this.list[i].top = tabHeight;
							tabHeight = tabHeight + data.height;
							this.list[i].bottom = tabHeight;
						}).exec();
					}
					this.load = false
				}
				let scrollTop = e.detail.scrollTop + 10;
				for (let i = 0; i < this.list.length; i++) {
					if (scrollTop > this.list[i].top && scrollTop < this.list[i].bottom) {
						this.verticalNavTop = (this.list[i].id - 1) * 50
						this.tabCur = this.list[i].id
						console.log(scrollTop)
						return false
					}
				}
			}
		}

	}
</script>

<style scoped>
	.outer {
		display: flex;
		flex-direction: column;/* 定了弹性子元素在父容器中的位置 */
		height: 100%;
	}

	.head {
		flex: 1;
	}

	.linked {
		flex: 1;
	}

	.footer {
		flex: 1;
		/* padding: 15rpx 0 15rpx 0; */
	}

	.head-container {
		display: flex;
		background-color: yellow;
	}

	.head-item {
		width: 20px;
		height: 20px;
		flex: 1;
	}




	.VerticalNav.nav {
		width: 200upx;
		white-space: initial;
	}

	.VerticalNav.nav .cu-item {
		width: 100%;
		text-align: center;
		background-color: #fff;
		margin: 0;
		border: none;
		height: 50px;
		position: relative;
	}

	.VerticalNav.nav .cu-item.cur {
		background-color: #f1f1f1;
	}

	.VerticalNav.nav .cu-item.cur::after {
		content: "";
		width: 8upx;
		height: 30upx;
		border-radius: 10upx 0 0 10upx;
		position: absolute;
		background-color: currentColor;
		top: 0;
		right: 0upx;
		bottom: 0;
		margin: auto;
	}

	.VerticalBox {
		display: flex;
	}

	.VerticalMain {
		background-color: #f1f1f1;
		flex: 1;
	}
</style>
