<template>
	<view>

		<h3>我是test组件{{msg}}</h3>
		<button type="primary" @click="test">event</button>

	</view>
</template>

<script>

	export default {
		data() {
			return {

			};

		},

		props: ["msg"],
		methods: {
			test() {
				// this.$emit('testShowName',{name:"young"})
				uni.$emit("testEmit", {
					name: "zj"
				})
			}
		}
	}
</script>

<style  scoped>

</style>
