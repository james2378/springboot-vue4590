<template>
	<div class="diy_home diy_list diy_competition_information" id="diy_competition_information_list">
		<!-- 列表 -->
		<div class="diy_view_list list list-x" v-if="show">
			<router-link class="diy_card goods diy_list_box_wrap" v-for="(o, i) in list" :key="i"
				:to="'/competition_information/details?competition_information_id=' + o['competition_information_id']">
				<!-- 图片 -->
				<div class="diy_list_img_box" v-if="imgList.length" >
					<div class="diy_row" v-for="(item,index) in imgList" :key="item+index" v-show="$check_field('get',item.name,'/competition_information/details') && +item.is_img_list">
						<div class="diy_title diy_list_img_title">
							<span>{{item.title}}:</span>
						</div>
						<div class="diy_field diy_img">
							<img :src="$fullUrl(o[item.name])" style="width:100%;height:100%" />
						</div>
					</div>
				</div>
				<!-- 内容 -->
				<div class="diy_list_item_box">
					<div class="diy_list_item_content" v-for="(item,index) in showItemList" :key="item+index">
						<div class="diy_row" :class="{[item.name]:true}" v-if="$check_field('get',item.name,'/competition_information/details') && +item.is_img_list">
							<div class="diy_title">
								<span>{{item.title}}:</span>
							</div>
							<div class="diy_field diy_text">
								<span v-if="item.type == 'UID'" v-text="get_user_name(item.name,o[item.name])"></span>
								<span v-else-if="item.type == '日期'" v-text="$toTime(o[item.name],'yyyy-MM-dd')"></span>
								<span v-else-if="item.type == '时间'" v-text="$toTime(o[item.name],'hh:mm:ss')"></span>
								<span v-else-if="item.type == '日长'" v-text="$toTime(o[item.name],'yyyy-MM-dd hh:mm:ss')"></span>
								<span v-else v-text="o[item.name]"></span>
							</div>
						</div>
					</div>
				</div>
			</router-link>
		</div>
		<!-- 表格 -->
		<div class="diy_view_table" v-else>
			<table class="diy_table">
				<tr class="diy_row">
						<th class="diy_title" v-if="$check_field('get','project_number')">
						项目编号
					</th>
							<th class="diy_title" v-if="$check_field('get','entry_name')">
						项目名称
					</th>
							<th class="diy_title" v-if="$check_field('get','competition_poster')">
						比赛海报
					</th>
							<th class="diy_title" v-if="$check_field('get','competition_classification')">
						比赛分类
					</th>
							<th class="diy_title" v-if="$check_field('get','competition_time')">
						比赛时间
					</th>
							<th class="diy_title" v-if="$check_field('get','number_of_participants_in_the_competition')">
						比赛人数
					</th>
							<th class="diy_title" v-if="$check_field('get','reportable_number_of_people')">
						可报人数
					</th>
							<th class="diy_title" v-if="$check_field('get','referee_account')">
						裁判账号
					</th>
							<th class="diy_title" v-if="$check_field('get','referee_name')">
						裁判姓名
					</th>
							<th class="diy_title" v-if="$check_field('get','competition_requirements')">
						比赛要求
					</th>
							<th class="diy_title" v-if="$check_field('get','introduction_to_judges')">
						裁判简介
					</th>
					</tr>
				<tr class="diy_row" v-for="(o,i) in list" :key="o+i">
						<td class="diy_field diy_text" v-if="$check_field('get','project_number')">
						<span>
							{{ o["project_number"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','entry_name')">
						<span>
							{{ o["entry_name"] }}
						</span>
					</td>
							<td class="diy_field" v-if="$check_field('get','competition_poster')">
						<img class="diy_img" :src="o['competition_poster']" />
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','competition_classification')">
						<span>
							{{ o["competition_classification"] }}
						</span>
					</td>
							<td class="diy_field diy_datetime" v-if="$check_field('get','competition_time')">
						<span>
							{{ $toTime(o["competition_time"] ,"yyyy-MM-dd hh:mm:ss") }}
						</span>
					</td>
							<td class="diy_field diy_number" v-if="$check_field('get','number_of_participants_in_the_competition')">
						<span>
							{{ o["number_of_participants_in_the_competition"] }}
						</span>
					</td>
							<td class="diy_field diy_number" v-if="$check_field('get','reportable_number_of_people')">
						<span>
							{{ o["reportable_number_of_people"] }}
						</span>
					</td>
							<td class="diy_field diy_uid" v-if="$check_field('get','referee_account')">
						<span>
							{{ get_user_name('referee_account',o['referee_account']) }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','referee_name')">
						<span>
							{{ o["referee_name"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','competition_requirements')">
						<span>
							{{ o["competition_requirements"] }}
						</span>
					</td>
							<td class="diy_field diy_text" v-if="$check_field('get','introduction_to_judges')">
						<span>
							{{ o["introduction_to_judges"] }}
						</span>
					</td>
					</tr>
			</table>
		</div>
	</div>
</template>

<script>
	export default {
		props: {
			list: {
				type: Array,
				default: function() {
					return [];
				},
			},
			show: {
				type: Boolean,
				default: function(){
					return true;
				}
			}
		},
		data() {
			return {
						imgList: [
						{
							title: "比赛海报",
							name: "competition_poster",
							type: "图片",
							is_img_list: "1"
						},
						],
						itemList: [
								{
									title: "项目编号",
									name: "project_number",
									type: "文本",
									is_img_list: "0"
								},
								{
									title: "项目名称",
									name: "entry_name",
									type: "文本",
									is_img_list: "1"
								},
								{
									title: "比赛分类",
									name: "competition_classification",
									type: "下拉",
									is_img_list: "1"
								},
								{
									title: "比赛时间",
									name: "competition_time",
									type: "日长",
									is_img_list: "1"
								},
								{
									title: "比赛人数",
									name: "number_of_participants_in_the_competition",
									type: "数字",
									is_img_list: "1"
								},
								{
									title: "可报人数",
									name: "reportable_number_of_people",
									type: "数字",
									is_img_list: "0"
								},
								{
									title: "裁判账号",
									name: "referee_account",
									type: "UID",
									is_img_list: "0"
								},
								{
									title: "裁判姓名",
									name: "referee_name",
									type: "下寻",
									is_img_list: "0"
								},
						],
						richList: [
								{
									title: "比赛要求",
									name: "competition_requirements",
									type: "多文本"
								},
								{
									title: "裁判简介",
									name: "introduction_to_judges",
									type: "多文本"
								},
						],
												// 用户列表
				list_user_referee_account: [],
							};
		},
		methods: {
			get_user_name(name,id){
				var obj = null;
												if (name == 'referee_account'){
					obj = this.list_user_referee_account.getObj({"user_id":id});
				}
								var ret = "";
				if(obj){
					ret = obj.nickname+"-"+obj.username;
					// if(obj.nickname){
					// 	ret = obj.nickname;
					// }
					// else{
					// 	ret = obj.username;
					// }
				}
				return ret;
			},
											/**
			 * 获取裁判员用户用户列表
			 */
			async get_list_user_referee_account() {
				var json = await this.$get("~/api/user/get_list?user_group=裁判员用户");
				if(json.result && json.result.list){
					this.list_user_referee_account = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
						},
		created() {
											this.get_list_user_referee_account();
						},
		computed:{
			showItemList(){
				let arr = [];
				let _type = ["视频","音频","文件"];
				this.itemList.forEach(item => {
					if(_type.indexOf(item.type) === -1 && !!+item.is_img_list){
						arr.push(item)
					}
				})
				return arr.slice(0,4);
			}
		}
	};
</script>

<style scoped>
	.media {
		display: flex;
		flex-direction: column;
		justify-content: space-between;
		flex-basis: 75%;
		min-height: 10rem;
	}

	.goods {
		display: flex;
		width: calc(25% - 1rem);
		margin: 0.5rem;
		padding: 0.5rem;
		flex-direction: column;
		justify-content: space-between;
		background-color: white;
		border-radius: 0.5rem;
	}

	.goods:hover {
		border: 0.2rem solid #909399;
		box-shadow: 0 0.1rem 0.3rem rgba(0, 0, 0, 0.15);
	}

	.goods:hover img {
		filter: blur(1px);
	}

	.price {
		font-size: 1rem;
		margin-right: 3px;
	}

	.price_ago {
		text-decoration: line-through;
		font-size: 0.5rem;
		color: #999;

	}

	.title {
		word-break: break-all;
		overflow: hidden;
		text-overflow: ellipsis;
		white-space: nowrap;
		font-weight: 700;
		padding: .25rem;
	}

	.icon_cart {
		color: #FF5722;
		float: right;
	}

	@media (max-width: 992px) {

		.goods {
			width: calc(33% - 1rem);
			;
		}

	}

	@media (max-width: 768px) {

		.goods {
			width: calc(50% - 1rem);
			;
		}

	}
</style>

