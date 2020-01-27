<template>
	<view class="content">
		<view class="video-js" ref="video">

		</view>
	</view>
</template>

<script>
	export default {
		onReady() {
			
			var video = document.createElement('video')
			video.id = 'video'
			video.style = 'width: 100%;height: 100%;'
			video.controls = true
			var source = document.createElement('source')
			source.src =
				'https://tv.youkutv.cc/2020/01/12/SzlcnpxUwCNTmZWr/playlist.m3u8'
			video.appendChild(source)
			this.$refs.video.$el.appendChild(video)
			videojs('video')
			
		},
		methods: {

		}
	}
</script>

<style>
	
</style>
