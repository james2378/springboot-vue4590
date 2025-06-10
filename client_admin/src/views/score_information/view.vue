<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">

							<el-col v-if="user_group === '管理员' || $check_field('get','referee_account') || $check_field('add','referee_account') || $check_field('set','referee_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="裁判账号" prop="referee_account">
													<el-select v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','referee_account')) || (!form['score_information_id'] && $check_field('add','referee_account'))" id="referee_account" v-model="form['referee_account']" :disabled="disabledObj['referee_account_isDisabled']">
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
												<el-input id="referee_name" v-model="form['referee_name']" placeholder="请输入裁判姓名"
							  v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','referee_name')) || (!form['score_information_id'] && $check_field('add','referee_name'))" :disabled="disabledObj['referee_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','referee_name')">{{form['referee_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','athlete_account') || $check_field('add','athlete_account') || $check_field('set','athlete_account')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="运动员账号" prop="athlete_account">
													<el-select v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','athlete_account')) || (!form['score_information_id'] && $check_field('add','athlete_account'))" id="athlete_account" v-model="form['athlete_account']" :disabled="disabledObj['athlete_account_isDisabled']">
							<el-option v-for="o in list_user_athlete_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
						<el-select v-else-if="$check_field('get','athlete_account')" id="athlete_account" v-model="form['athlete_account']" :disabled="true">
							<el-option v-for="o in list_user_athlete_account" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','athletes') || $check_field('add','athletes') || $check_field('set','athletes')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="运动员" prop="athletes">
												<el-input id="athletes" v-model="form['athletes']" placeholder="请输入运动员"
							  v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','athletes')) || (!form['score_information_id'] && $check_field('add','athletes'))" :disabled="disabledObj['athletes_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','athletes')">{{form['athletes']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','gender') || $check_field('add','gender') || $check_field('set','gender')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="性别" prop="gender">
												<el-input id="gender" v-model="form['gender']" placeholder="请输入性别"
							  v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','gender')) || (!form['score_information_id'] && $check_field('add','gender'))" :disabled="disabledObj['gender_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','gender')">{{form['gender']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','age') || $check_field('add','age') || $check_field('set','age')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="年龄" prop="age">
								<el-input-number id="age" v-model.number="form['age']"
						v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','age')) || (!form['score_information_id'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']"></el-input-number>
					<div v-else-if="$check_field('get','age')">{{form['age']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','project_number') || $check_field('add','project_number') || $check_field('set','project_number')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目编号" prop="project_number">
												<el-input id="project_number" v-model="form['project_number']" placeholder="请输入项目编号"
							  v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','project_number')) || (!form['score_information_id'] && $check_field('add','project_number'))" :disabled="disabledObj['project_number_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','project_number')">{{form['project_number']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','entry_name') || $check_field('add','entry_name') || $check_field('set','entry_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="项目名称" prop="entry_name">
												<el-input id="entry_name" v-model="form['entry_name']" placeholder="请输入项目名称"
							  v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','entry_name')) || (!form['score_information_id'] && $check_field('add','entry_name'))" :disabled="disabledObj['entry_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','entry_name')">{{form['entry_name']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_classification') || $check_field('add','competition_classification') || $check_field('set','competition_classification')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛分类" prop="competition_classification">
												<el-input id="competition_classification" v-model="form['competition_classification']" placeholder="请输入比赛分类"
							  v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','competition_classification')) || (!form['score_information_id'] && $check_field('add','competition_classification'))" :disabled="disabledObj['competition_classification_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','competition_classification')">{{form['competition_classification']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','competition_time') || $check_field('add','competition_time') || $check_field('set','competition_time')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛时间" prop="competition_time">
								<el-date-picker :disabled="disabledObj['competition_time_isDisabled']" v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','competition_time')) || (!form['score_information_id'] && $check_field('add','competition_time'))" id="competition_time"
						v-model="form['competition_time']" type="datetime" placeholder="选择日期时间">
					</el-date-picker>
					<div v-else-if="$check_field('get','competition_time')">{{form['competition_time']}}</div>
							</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','score') || $check_field('add','score') || $check_field('set','score')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="比赛成绩" prop="score">
												<el-input id="score" v-model="form['score']" placeholder="请输入比赛成绩"
							  v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','score')) || (!form['score_information_id'] && $check_field('add','score'))" :disabled="disabledObj['score_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','score')">{{form['score']}}</div>
											</el-form-item>
			</el-col>
								<el-col v-if="user_group === '管理员' || $check_field('get','score_description') || $check_field('add','score_description') || $check_field('set','score_description')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="成绩说明" prop="score_description">
								<el-input type="textarea" id="score_description" v-model="form['score_description']" placeholder="请输入成绩说明"
						v-if="user_group === '管理员' || (form['score_information_id'] && $check_field('set','score_description')) || (!form['score_information_id'] && $check_field('add','score_description'))" :disabled="disabledObj['score_description_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','score_description')">{{form['score_description']}}</div>
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
				field: "score_information_id",
				url_add: "~/api/score_information/add?",
				url_set: "~/api/score_information/set?",
				url_get_obj: "~/api/score_information/get_obj?",
				url_upload: "~/api/score_information/upload?",

				query: {
					"score_information_id": 0,
				},

				form: {
								"referee_account": 0, // 裁判账号
										"referee_name":  '', // 裁判姓名
										"athlete_account": 0, // 运动员账号
										"athletes":  '', // 运动员
										"gender":  '', // 性别
										"age":  0, // 年龄
										"project_number":  '', // 项目编号
										"entry_name":  '', // 项目名称
										"competition_classification":  '', // 比赛分类
										"competition_time":  '', // 比赛时间
										"score":  '', // 比赛成绩
										"score_description":  '', // 成绩说明
											"score_information_id": 0, // ID
						
				},
				disabledObj:{
								"referee_account_isDisabled": false,
										"referee_name_isDisabled": false,
										"athlete_account_isDisabled": false,
										"athletes_isDisabled": false,
										"gender_isDisabled": false,
					          			"age_isDisabled": false,
										"project_number_isDisabled": false,
										"entry_name_isDisabled": false,
										"competition_classification_isDisabled": false,
										"competition_time_isDisabled": false,
										"score_isDisabled": false,
										"score_description_isDisabled": false,
										},

	
					// 用户列表
				list_user_referee_account: [],
				
		
					// 用户列表
				list_user_athlete_account: [],
				
		
		
		
		
		
		
		
		
	
			}
		},
		methods: {


	
	
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
			 * 获取运动员用户用户列表
			 */
			async get_list_user_athlete_account() {
                // if(this.user_group !== "管理员" && this.form["athlete_account"] === 0) {
                //     this.form["athlete_account"] = this.user.user_id;
                // }
                var json = await this.$get("~/api/user/get_list?user_group=运动员用户");
                if(json.result && json.result.list){
                    this.list_user_athlete_account = json.result.list;
                }
                else if(json.error){
                    console.error(json.error);
                }
			},
					get_user_athlete_account(id){
				var obj = this.list_user_athlete_account.getObj({"user_id":id});
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
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
																// 获取缓存数据附加
				form = $.db.get("form");
							$.push(this.form ,form);
								
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
					bl = this.$check_action('/score_information/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/score_information/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/score_information/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/score_information/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/score_information/view','get');
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
										this.get_list_user_athlete_account();
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
