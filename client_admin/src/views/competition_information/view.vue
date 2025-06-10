<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','project_number') || $check_field('add','project_number') || $check_field('set','project_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目编号" prop="project_number">
												<el-input id="project_number" v-model="form['project_number']" placeholder="请输入项目编号"
							  v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','project_number')) || (!form['competition_information_id'] && $check_field('add','project_number'))" :disabled="true"></el-input>
					<div v-else-if="$check_field('get','project_number')">{{form['project_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','entry_name') || $check_field('add','entry_name') || $check_field('set','entry_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目名称" prop="entry_name">
												<el-input id="entry_name" v-model="form['entry_name']" placeholder="请输入项目名称"
							  v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','entry_name')) || (!form['competition_information_id'] && $check_field('add','entry_name'))" :disabled="disabledObj['entry_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','entry_name')">{{form['entry_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_poster') || $check_field('add','competition_poster') || $check_field('set','competition_poster')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛海报" prop="competition_poster">
								<el-upload :disabled="disabledObj['competition_poster_isDisabled']" id="competition_poster" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_competition_poster"
						:show-file-list="false" v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','competition_poster')) || (!form['competition_information_id'] && $check_field('add','competition_poster'))">
						<img v-if="form['competition_poster']" :src="$fullUrl(form['competition_poster'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','competition_poster')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['competition_poster'])" :preview-src-list="[$fullUrl(form['competition_poster'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_classification') || $check_field('add','competition_classification') || $check_field('set','competition_classification')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛分类" prop="competition_classification">
								<el-select id="competition_classification" v-model="form['competition_classification']"
						v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','competition_classification')) || (!form['competition_information_id'] && $check_field('add','competition_classification'))">
						<el-option v-for="o in list_competition_classification" :key="o" :label="o" :value="o">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','competition_classification')">{{form['competition_classification']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_time') || $check_field('add','competition_time') || $check_field('set','competition_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛时间" prop="competition_time">
								<el-date-picker :disabled="disabledObj['competition_time_isDisabled']" v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','competition_time')) || (!form['competition_information_id'] && $check_field('add','competition_time'))" id="competition_time"
						v-model="form['competition_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','competition_time')">{{form['competition_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','number_of_participants_in_the_competition') || $check_field('add','number_of_participants_in_the_competition') || $check_field('set','number_of_participants_in_the_competition')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛人数" prop="number_of_participants_in_the_competition">
								<el-input-number id="number_of_participants_in_the_competition" v-model.number="form['number_of_participants_in_the_competition']"
						v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','number_of_participants_in_the_competition')) || (!form['competition_information_id'] && $check_field('add','number_of_participants_in_the_competition'))" :disabled="disabledObj['number_of_participants_in_the_competition_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','number_of_participants_in_the_competition')">{{form['number_of_participants_in_the_competition']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','reportable_number_of_people') || $check_field('add','reportable_number_of_people') || $check_field('set','reportable_number_of_people')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="可报人数" prop="reportable_number_of_people">
								<el-input-number id="reportable_number_of_people" v-model.number="form['reportable_number_of_people']"
						v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','reportable_number_of_people')) || (!form['competition_information_id'] && $check_field('add','reportable_number_of_people'))" :disabled="disabledObj['reportable_number_of_people_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','reportable_number_of_people')">{{form['reportable_number_of_people']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','referee_account') || $check_field('add','referee_account') || $check_field('set','referee_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="裁判账号" prop="referee_account">
													<el-select v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','referee_account')) || (!form['competition_information_id'] && $check_field('add','referee_account'))" id="referee_account" v-model="form['referee_account']" :disabled="disabledObj['referee_account_isDisabled']">
							<el-option v-for="o in list_user_referee_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','referee_account')" id="referee_account" v-model="form['referee_account']" :disabled="true">
							<el-option v-for="o in list_user_referee_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','referee_name') || $check_field('add','referee_name') || $check_field('set','referee_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="裁判姓名" prop="referee_name">
								<el-select id="referee_name" v-model="form['referee_name']"
						v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','referee_name')) || (!form['competition_information_id'] && $check_field('add','referee_name'))">
						<el-option v-for="o in list_referee_name" :key="o['referee_name']" :label="o['referee_name']"
							:value="o['referee_name']">
						</el-option>
					</el-select>
					<div v-else-if="$check_field('get','referee_name')">{{form['referee_name']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_requirements') || $check_field('add','competition_requirements') || $check_field('set','competition_requirements')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛要求" prop="competition_requirements">
								<el-input type="textarea" id="competition_requirements" v-model="form['competition_requirements']" placeholder="请输入比赛要求"
						v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','competition_requirements')) || (!form['competition_information_id'] && $check_field('add','competition_requirements'))" :disabled="disabledObj['competition_requirements_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_requirements')">{{form['competition_requirements']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','introduction_to_judges') || $check_field('add','introduction_to_judges') || $check_field('set','introduction_to_judges')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="裁判简介" prop="introduction_to_judges">
								<el-input type="textarea" id="introduction_to_judges" v-model="form['introduction_to_judges']" placeholder="请输入裁判简介"
						v-if="user_group === '管理员' || (form['competition_information_id'] && $check_field('set','introduction_to_judges')) || (!form['competition_information_id'] && $check_field('add','introduction_to_judges'))" :disabled="disabledObj['introduction_to_judges_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','introduction_to_judges')">{{form['introduction_to_judges']}}</div>
							</el-form-item>
			</el-col>
					
	
	
	
	
	
	
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "competition_information_id",
				url_add: "~/api/competition_information/add?",
				url_set: "~/api/competition_information/set?",
				url_get_obj: "~/api/competition_information/get_obj?",
				url_upload: "~/api/competition_information/upload?",

				query: {
					"competition_information_id": 0,
				},

				form: {
								"project_number": this.$get_stamp(), // 项目编号
										"entry_name":  '', // 项目名称
										"competition_poster":  '', // 比赛海报
										"competition_classification":  '', // 比赛分类
										"competition_time":  '', // 比赛时间
										"number_of_participants_in_the_competition":  0, // 比赛人数
										"reportable_number_of_people":  0, // 可报人数
										"referee_account": 0, // 裁判账号
										"referee_name":  '', // 裁判姓名
										"competition_requirements":  '', // 比赛要求
										"introduction_to_judges":  '', // 裁判简介
											"competition_information_id": 0, // ID
						
				},
				disabledObj:{
								"project_number_isDisabled": false,
										"entry_name_isDisabled": false,
										"competition_poster_isDisabled": false,
										"competition_classification_isDisabled": false,
										"competition_time_isDisabled": false,
					          			"number_of_participants_in_the_competition_isDisabled": false,
					          			"reportable_number_of_people_isDisabled": false,
										"referee_account_isDisabled": false,
										"referee_name_isDisabled": false,
										"competition_requirements_isDisabled": false,
										"introduction_to_judges_isDisabled": false,
										},

	
		
		
						// 比赛分类选项列表
				list_competition_classification: ['女子组','男子组','混合组'],
	
		
		
		
		
					// 用户列表
				list_user_referee_account: [],
								// 裁判姓名选项列表
				list_referee_name: [""],
	
		
		
	
			}
		},
		methods: {


	
	
			
	
						/**
			 * 上传比赛海报
			 * @param {Object} param 图片参数
			 */
			upload_competition_poster(param){
						this.uploadFile(param.file, "competition_poster");
					},
	
	
			
	
			
	
			
	
			
	
			
	
				/**
			 * 获取裁判员用户用户列表
			 */
			async get_list_user_referee_account() {
                // if(this.user_group !== "管理员" && this.form["referee_account"] === 0) {
                //     this.form["referee_account"] = this.user.user_id;
                // }
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
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			
				/**
			 * 获取裁判姓名列表
			 */
			async get_list_referee_name() {
				var json = await this.$get("~/api/referee_user/get_list?");
				if(json.result && json.result.list){
					this.list_referee_name = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
	
			
	
			
	
		
			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
															
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
									        if (this.form["competition_time"].indexOf("-")===-1){
            this.form["competition_time"] = this.$toTime(parseInt(this.form["competition_time"]),"yyyy-MM-dd hh:mm:ss")
        }
																		$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){


													        if(this.form["competition_time"]=="0000-00-00 00:00:00"){
          this.form["competition_time"] = null;
        }
				if(parseInt(this.form["competition_time"]) > 9999){
					this.form["competition_time"] = this.$toTime(parseInt(this.form["competition_time"]),"yyyy-MM-dd hh:mm:ss")
				}
																					


			},

			/**
			 * 提交前验证事件
			 * @param {Object} 请求参数
			 * @return {String} 验证成功返回null, 失败返回错误提示
			 */
			submit_check(param) {
				let msg = null
																																							return msg;
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/competition_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/competition_information/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
																			this.get_list_user_referee_account();
							this.get_list_referee_name();
								},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}




</style>
