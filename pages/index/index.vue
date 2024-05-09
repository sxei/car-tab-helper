<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
			<button type="primary" @click="test">测试</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: '你好啊！'
			}
		},
		onLoad() {

		},
		methods: {
			test() {
				
				this.getBattery();
			},
			getBattery() {
				// uni.showToast({
				// 	title: uni.getStorageSync('homePage'),
				// 	duration: 3000
				// });
				// return;
				uni.getBatteryInfo({
					success: (res) => {
						uni.showModal({
							title: '提示',
							content: JSON.stringify(res),
						});
					}
				})
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
