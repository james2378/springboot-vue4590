<template>
	<el-main class="bg table_wrap">
		<el-form label-position="right" :model="query" class="form p_4" label-width="120">
			<el-row>


										<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="项目名称">
									<el-input v-model="query.entry_name"></el-input>
								</el-form-item>
				</el-col>
												<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="比赛分类">
									<el-select v-model="query.competition_classification">
				                            <el-option v-for="o in list_competition_classification" :key="o" :label="o"
                            	:value="o">
                            </el-option>
										</el-select>
								</el-form-item>
				</el-col>
									<el-col :xs="24" :sm="24" :lg="8" class="el_form_search_wrap">
					<el-form-item label="比赛时间">
									<el-input v-model="query.competition_time"></el-input>
								</el-form-item>
				</el-col>
																									<el-col :xs="24" :sm="10" :lg="8" class="search_btn_wrap_1">
					<el-form-item>
						<el-button type="primary" @click="search()" class="search_btn_find">查询</el-button>
						<el-button @click="reset()" style="margin-right: 74px;" class="search_btn_reset">重置</el-button>
						<router-link v-if="user_group == '管理员' || $check_action('/competition_information/table','add') || $check_action('/competition_information/view','add')" class="el-button el-button--default el-button--primary search_btn_add" to="./view?">添加
						</router-link>
            			<el-button v-if="user_group == '管理员' || $check_action('/competition_information/table','del') || $check_action('/competition_information/view','del')" class="search_btn_del" type="danger" @click="delInfo()">删除</el-button>
					</el-form-item>
				</el-col>

			</el-row>
		</el-form>
		<el-table :data="list" @selection-change="selectionChange" @sort-change="$sortChange" style="width: 100%" id="dataTable">
			<el-table-column fixed type="selection" tooltip-effect="dark" width="55">
			</el-table-column>
				<el-table-column prop="project_number" @sort-change="$sortChange" label="项目编号"
				v-if="user_group == '管理员' || $check_field('get','project_number')" min-width="200">
					</el-table-column>
					<el-table-column prop="entry_name" @sort-change="$sortChange" label="项目名称"
				v-if="user_group == '管理员' || $check_field('get','entry_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="competition_poster" @sort-change="$sortChange" label="比赛海报"
				v-if="user_group == '管理员' || $check_field('get','competition_poster')" min-width="200">
						<template slot-scope="scope">
					<el-image style="width: 100px; height: 100px" :src="$fullUrl(scope.row['competition_poster'])"
						:preview-src-list="[$fullUrl(scope.row['competition_poster'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</template>
					</el-table-column>
					<el-table-column prop="competition_classification" @sort-change="$sortChange" label="比赛分类"
				v-if="user_group == '管理员' || $check_field('get','competition_classification')" min-width="200">
					</el-table-column>
					<el-table-column prop="competition_time" @sort-change="$sortChange" label="比赛时间"
				v-if="user_group == '管理员' || $check_field('get','competition_time')" min-width="200">
						<template slot-scope="scope">
					{{ $toTime(scope.row["competition_time"],"yyyy-MM-dd hh:mm:ss") }}
				</template>
					</el-table-column>
					<el-table-column prop="number_of_participants_in_the_competition" @sort-change="$sortChange" label="比赛人数"
				v-if="user_group == '管理员' || $check_field('get','number_of_participants_in_the_competition')" min-width="200">
					</el-table-column>
					<el-table-column prop="reportable_number_of_people" @sort-change="$sortChange" label="可报人数"
				v-if="user_group == '管理员' || $check_field('get','reportable_number_of_people')" min-width="200">
					</el-table-column>
					<el-table-column prop="referee_account" @sort-change="$sortChange" label="裁判账号"
				v-if="user_group == '管理员' || $check_field('get','referee_account')" min-width="200">
						<template slot-scope="scope">
					{{ get_user_referee_account(scope.row['referee_account']) }}
				</template>
					</el-table-column>
					<el-table-column prop="referee_name" @sort-change="$sortChange" label="裁判姓名"
				v-if="user_group == '管理员' || $check_field('get','referee_name')" min-width="200">
					</el-table-column>
					<el-table-column prop="competition_requirements" @sort-change="$sortChange" label="比赛要求"
				v-if="user_group == '管理员' || $check_field('get','competition_requirements')" min-width="200">
					</el-table-column>
					<el-table-column prop="introduction_to_judges" @sort-change="$sortChange" label="裁判简介"
				v-if="user_group == '管理员' || $check_field('get','introduction_to_judges')" min-width="200">
					</el-table-column>
	



            <el-table-column sortable prop="create_time" label="创建时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["create_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
            </el-table-column>

			<el-table-column sortable prop="update_time" label="更新时间" min-width="200">
                <template slot-scope="scope">
                	{{ $toTime(scope.row["update_time"],"yyyy-MM-dd hh:mm:ss") }}
                </template>
			</el-table-column>







			<el-table-column fixed="right" label="操作" min-width="120" v-if="user_group == '管理员' || $check_action('/competition_information/table','set') || $check_action('/competition_information/view','set') || $check_action('/competition_information/view','get') || $check_action('/参赛报名/table','add') || $check_action('/参赛报名/view','add')" >


				<template slot-scope="scope">
					<router-link class="el-button el-button--small is-plain el-button--success" style="margin: 5px !important;"
					v-if="user_group == '管理员' || $check_action('/competition_information/table','set') || $check_action('/competition_information/view','set') || $check_action('/competition_information/view','get')"
						:to="'./view?' + field + '=' + scope.row[field]"
						 size="small">
						<span>详情</span>
					</router-link>
						<!--跨表按钮-->
							<el-button class="el-button el-button--small is-plain el-button--default" style="margin: 5px !important;" size="small" @click="to_table(scope.row,'/registration_information/view')" v-if="user_group == '管理员' || $check_action('/registration_information/table','add') || $check_action('/registration_information/view','add')">
						<span>参赛报名</span>
					</el-button>
									<router-link v-if="user_group == '管理员' || $check_comment('/competition_information/table')" class="el-button el-button--small is-plain el-button--primary"
								  :to="'../comment/table?size=10&page=1&source_table=competition_information&source_field=' + field + '&source_id=' + scope.row[field]" size="small">
					查看评论
					</router-link>
					</template>
			</el-table-column>

		</el-table>

		<!-- 分页器 -->
		<div class="mt text_center">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange"
				:current-page="query.page" :page-sizes="[7, 10, 30, 100]" :page-size="query.size"
				layout="total, sizes, prev, pager, next, jumper" :total="count">
			</el-pagination>
		</div>
		<!-- /分页器 -->

											
		<div class="modal_wrap" v-if="showModal">
			<div class="modal_box">
				<!-- <div class="modal_box_close" @click="closeModal">X</div> -->
				<p class="modal_box_title">重要提醒</p>
				<p class="modal_box_text">当前有数据达到预警值！</p>
				<div class="btn_box">
					<span @click="closeModal">取消</span>
					<span @click="closeModal">确定</span>
				</div>
			</div>
		</div>


	</el-main>
</template>
<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				// 弹框
				showModal: false,
				// 获取数据地址
				url_get_list: "~/api/competition_information/get_list?like=0",
				url_del: "~/api/competition_information/del?",

				// 字段ID
				field: "competition_information_id",

				// 查询
				query: {
					"size": 7,
					"page": 1,
									"entry_name": "",
												"competition_classification": "",
											"competition_time": "",
														"login_time": "",
					"create_time": "",
					"orderby": `create_time desc`
				},

				// 数据
				list: [],
																						// 比赛分类列表
				list_competition_classification: ['女子组','男子组','混合组'],
																// 用户列表
				list_user_referee_account: [],
						// 裁判姓名列表
				list_referee_name: [""],
									}
		},
		methods: {
			// 关闭弹框
			closeModal(){
				this.showModal = false;
				},

			get_list_before(param){
				var user_group = this.user.user_group;
				if(user_group != "管理员"){
						let sqlwhere = "(";
																																													if(user_group=="裁判员用户"){
						sqlwhere+= "referee_account = " + this.user.user_id + " or ";
					}
																									if (sqlwhere.length>1){
						sqlwhere = sqlwhere.substr(0,sqlwhere.length-4);
						sqlwhere += ")";
						param["sqlwhere"] = sqlwhere;
					}
					}
				return param;
			},

																				/**
			 * 获取裁判姓名列表
			 */
			async get_list_referee_name() {
				var json = await this.$get("~/api/referee_user/get_list?");
				if(json.result){
					this.list_referee_name = json.result.list;
				}else if (json.error){
					console.log(json.error);
				}
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

			get_user_referee_account(id){
				var obj = this.list_user_referee_account.getObj({"user_id":id});
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
											deleteRow(index, rows) {
				rows.splice(index, 1);
			}

		},
		created() {
																					this.get_list_user_referee_account();
					// 初始化裁判姓名列表
			this.get_list_referee_name();
								}
	}
</script>

<style type="text/css">
	.bg {
		background: white;
	}

	.form.p_4 {
		padding: 1rem;
	}

	.form .el-input {
		width: initial;
	}

	.mt {
		margin-top: 1rem;
	}

	.text_center {
		text-align: center;
	}

	.float-right {
		float: right;
	}


	.modal_wrap{
		width: 100vw;
		height: 100vh;
		position: fixed;
		top: 0;
		left: 0;
		background: rgba(0,0,0,0.5);
		z-index: 9999999999;
	}
	.modal_wrap .modal_box{
		width: 400px;
		height: 200px;
		background: url("../../assets/modal_bg.jpg") no-repeat center;
		background-size: cover;
		position: absolute;
		top: 50%;
		left: 50%;
		margin-left: -200px;
		margin-top: -100px;
		border-radius: 10px;
		}
	.modal_wrap .modal_box .modal_box_close{
		font-size: 20px;
		position: absolute;
		top: 10px;
		right: 10px;
		cursor: pointer;
		}
	.modal_wrap .modal_box .modal_box_title{
	  text-align: center;
    font-size: 18px;
    margin: 16px auto;
    color: #fff;
    border-bottom: 1px solid rgba(117, 116, 116,0.5);
    padding-bottom: 16px;
    width: 356px;
		}
	.modal_wrap .modal_box .modal_box_text{
			text-align: center;
		font-size: 15px;
		color: #fff;
		margin-top: 25px;
		}
	.modal_wrap .modal_box .btn_box{
		display: flex;
		flex-direction: row;
		justify-content: center;
		margin-top: 42px;
		}
			.modal_wrap .modal_box .btn_box span{
				display: inline-block;
				width: 80px;
				height: 30px;
				line-height: 30px;
				text-align: center;
				border: 1px solid #ccc;
				font-size: 14px;
				cursor: pointer;
				color: #fff;
			}
	.modal_wrap .modal_box .btn_box span:nth-child(2){
		background: #409EFF;
		color: #fff;
		border-color: #409EFF;
		margin-left: 15px;
	}
</style>
