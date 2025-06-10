<template>
	<div class="diy_edit page_registration_information" id="registration_information_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
						<div v-if="$check_field('set','athlete_account') || $check_field('add','athlete_account') || $check_field('get','athlete_account')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								运动员账号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_athlete_account" :disabled="disabledObj['athlete_account_isDisabled']" v-model="form['athlete_account']" v-if="(form['athlete_account'] && $check_field('set','athlete_account')) || (!form['athlete_account'] && $check_field('add','athlete_account'))" >
								<option v-for="o in list_user_athlete_account" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','athlete_account')">{{ form['athlete_account'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','athletes') || $check_field('add','athletes') || $check_field('get','athletes')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								运动员:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_athletes" v-model="form['athletes']" placeholder="请输入运动员" v-if="(form['athletes'] && $check_field('set','athletes')) || (!form['athletes'] && $check_field('add','athletes'))"  :disabled="disabledObj['athletes_isDisabled']"/>
							<span v-else-if="$check_field('get','athletes')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','gender') || $check_field('add','gender') || $check_field('get','gender')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								性别:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_gender" v-model="form['gender']" placeholder="请输入性别" v-if="(form['gender'] && $check_field('set','gender')) || (!form['gender'] && $check_field('add','gender'))"  :disabled="disabledObj['gender_isDisabled']"/>
							<span v-else-if="$check_field('get','gender')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','age') || $check_field('add','age') || $check_field('get','age')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								年龄:
							</span>
						</div>
								<!-- 数字 -->
						<div class="diy_field diy_number">
							<input type="number" id="form_age" v-model.number="form['age']" placeholder="请输入年龄" v-if="(form['age'] && $check_field('set','age')) || (!form['age'] && $check_field('add','age'))" :disabled="disabledObj['age_isDisabled']" />
							<span v-else-if="$check_field('get','age')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','project_number') || $check_field('add','project_number') || $check_field('get','project_number')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								项目编号:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_project_number" v-model="form['project_number']" placeholder="请输入项目编号" v-if="(form['project_number'] && $check_field('set','project_number')) || (!form['project_number'] && $check_field('add','project_number'))"  :disabled="disabledObj['project_number_isDisabled']"/>
							<span v-else-if="$check_field('get','project_number')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','entry_name') || $check_field('add','entry_name') || $check_field('get','entry_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								项目名称:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_entry_name" v-model="form['entry_name']" placeholder="请输入项目名称" v-if="(form['entry_name'] && $check_field('set','entry_name')) || (!form['entry_name'] && $check_field('add','entry_name'))"  :disabled="disabledObj['entry_name_isDisabled']"/>
							<span v-else-if="$check_field('get','entry_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','competition_classification') || $check_field('add','competition_classification') || $check_field('get','competition_classification')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								比赛分类:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_competition_classification" v-model="form['competition_classification']" placeholder="请输入比赛分类" v-if="(form['competition_classification'] && $check_field('set','competition_classification')) || (!form['competition_classification'] && $check_field('add','competition_classification'))"  :disabled="disabledObj['competition_classification_isDisabled']"/>
							<span v-else-if="$check_field('get','competition_classification')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','competition_time') || $check_field('add','competition_time') || $check_field('get','competition_time')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								比赛时间:
							</span>
						</div>
								<!-- 日长 -->
						<div class="diy_field diy_datetime">
							<input type="datetime-local" :disabled="disabledObj['competition_time_isDisabled']" id="form_competition_time" v-model="form['competition_time']" placeholder="请输入比赛时间" v-if="(form['competition_time'] && $check_field('set','competition_time')) || (!form['competition_time'] && $check_field('add','competition_time'))" />
							<span v-else-if="$check_field('get','competition_time')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','referee_account') || $check_field('add','referee_account') || $check_field('get','referee_account')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								裁判账号:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_referee_account" :disabled="disabledObj['referee_account_isDisabled']" v-model="form['referee_account']" v-if="(form['referee_account'] && $check_field('set','referee_account')) || (!form['referee_account'] && $check_field('add','referee_account'))" >
								<option v-for="o in list_user_referee_account" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','referee_account')">{{ form['referee_account'] }}</span>
						</div>
					</div>
							<div v-if="$check_field('set','referee_name') || $check_field('add','referee_name') || $check_field('get','referee_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								裁判姓名:
							</span>
						</div>
								<!-- 文本 -->
									<div class="diy_field diy_text">
							<input type="text" id="form_referee_name" v-model="form['referee_name']" placeholder="请输入裁判姓名" v-if="(form['referee_name'] && $check_field('set','referee_name')) || (!form['referee_name'] && $check_field('add','referee_name'))"  :disabled="disabledObj['referee_name_isDisabled']"/>
							<span v-else-if="$check_field('get','referee_name')">{{ form['${obj.name}'] }}</span>
						</div>
										</div>
							<div v-if="$check_field('set','number_of_applicants') || $check_field('add','number_of_applicants') || $check_field('get','number_of_applicants')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								报名人数:
							</span>
						</div>
								<!-- 数字 -->
						<div class="diy_field diy_number">
							<input type="number" id="form_number_of_applicants" v-model.number="form['number_of_applicants']" placeholder="请输入报名人数" v-if="(form['number_of_applicants'] && $check_field('set','number_of_applicants')) || (!form['number_of_applicants'] && $check_field('add','number_of_applicants'))" :disabled="disabledObj['number_of_applicants_isDisabled']" />
							<span v-else-if="$check_field('get','number_of_applicants')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
							<div v-if="$check_field('set','information_remarks') || $check_field('add','information_remarks') || $check_field('get','information_remarks')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								信息备注:
							</span>
						</div>
								<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_information_remarks" v-model="form['information_remarks']" v-if="(form['information_remarks'] && $check_field('set','information_remarks')) || (!form['information_remarks'] && $check_field('add','information_remarks'))" :disabled="disabledObj['information_remarks_isDisabled']" />
							<span v-else-if="$check_field('get','information_remarks')">{{ form['${obj.name}'] }}</span>
						</div>
							</div>
	


					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核状态:
							</span>
						</div>
						<div class="diy_field diy_select" v-if="$check_action('/registration_information/edit','examine')">
							<!--<span> {{ form['examine_state'] }} </span>-->
							<select v-model="form['examine_state']">
								<option value="未审核">
									未审核
								</option>
								<option value="已通过">
									已通过
								</option>
								<option value="未通过">
									未通过
								</option>
							</select>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_state'] }}
							</span>
						</div>
					</div>
					<div v-if="user_group === '管理员' || $check_examine()" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>
								审核回复:
							</span>
						</div>
						<div class="diy_field diy_desc" v-if="$check_action('/registration_information/edit','examine')">
							<textarea v-model="form['examine_reply']"></textarea>
						</div>
						<div class="diy_field diy_text" v-else>
							<span>
								{{ form['examine_reply'] }}
							</span>
						</div>
					</div>


				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/registration_information/get_obj?",
				url_add: "~/api/registration_information/add?",
				url_set: "~/api/registration_information/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
						"athlete_account": 0,
							"athletes": "",
							"gender": "",
							"age": 0,
							"project_number": "",
							"entry_name": "",
							"competition_classification": "",
							"competition_time": "",
							"referee_account": 0,
							"referee_name": "",
							"number_of_applicants": 0,
							"information_remarks": "",
						"registration_information_id": 0,
				},

				obj: {
						"athlete_account": 0, // 运动员账号
							"athletes":  '', // 运动员
							"gender":  '', // 性别
							"age":  0, // 年龄
							"project_number":  '', // 项目编号
							"entry_name":  '', // 项目名称
							"competition_classification":  '', // 比赛分类
							"competition_time": new Date().getTime(),
							"referee_account": 0, // 裁判账号
							"referee_name":  '', // 裁判姓名
							"number_of_applicants":  0, // 报名人数
							"information_remarks":  '', // 信息备注
						"examine_state": "未审核",
					"examine_reply": "",
					"registration_information_id": 0,
				},

				// 表单字段
				form: {
						"athlete_account": 0, // 运动员账号
							"athletes":  '', // 运动员
							"gender":  '', // 性别
							"age":  0, // 年龄
							"project_number":  '', // 项目编号
							"entry_name":  '', // 项目名称
							"competition_classification":  '', // 比赛分类
							"competition_time": new Date().getTime(),
							"referee_account": 0, // 裁判账号
							"referee_name":  '', // 裁判姓名
							"number_of_applicants":  0, // 报名人数
							"information_remarks":  '', // 信息备注
						"examine_state": "未审核",
					"examine_reply": "",
					"registration_information_id": 0,
				},
				disabledObj:{
						"athlete_account_isDisabled": false,
							"athletes_isDisabled": false,
							"gender_isDisabled": false,
									"project_number_isDisabled": false,
							"entry_name_isDisabled": false,
							"competition_classification_isDisabled": false,
							"competition_time_isDisabled": false,
							"referee_account_isDisabled": false,
							"referee_name_isDisabled": false,
									"information_remarks_isDisabled": false,
					},

						// 用户列表
				list_user_athlete_account: [],
																					// 用户列表
				list_user_referee_account: [],
							
				// ID字段
				field: "registration_information_id",

			}
		},
		methods: {
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
					async get_user_session_athlete_account(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=运动员用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["athlete_account"] = user_id
								_this.disabledObj['athlete_account' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
                  if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
                    for (var j = 0; j < arrForm.length; j++) {
                      if (arr[i] === arrForm[j]) {
                        if (arr[i] !== "athlete_account") {
                          _this.form[arrForm[j]] = res.result.obj[arr[i]]
                          _this.disabledObj[arrForm[j] + '_isDisabled'] = true
                          break;
                        }
                      }
                    }
                  }
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
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
		
				
				
				
	
			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/registration_information/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
        //   this.obj = $.push(this.obj ,form);
				// 	this.form = $.push(this.form ,form);
				// }
				// var arr = []
				// for (let key in form) {
				// 	arr.push(key)
				// }
				// for (var i=0;i<arr.length;i++){
				// 	this.disabledObj[arr[i] + '_isDisabled'] = true
				// }
        if (form) {
          var arr = []
          for (let key in form) {
            arr.push(key)
          }
          var arrForm = []
          for (let key in this.form) {
            arrForm.push(key)
          }
          for (var i=0;i<arr.length;i++){
            if (arr[i]!=='examine_state' && arr[i]!=='examine_reply') {
              for (var j = 0; j < arrForm.length; j++) {
                if (arrForm[j] === arr[i]) {
                  this.form[arrForm[j]] = form[arr[i]]
                  this.obj[arrForm[j]] = form[arr[i]]
                  this.disabledObj[arrForm[j] + '_isDisabled'] = true
                  break;
                }
              }
            }
          }
        }
															        if (JSON.stringify(this.form["competition_time"]).indexOf("-")===-1) {
          this.form["competition_time"] = this.$toTime(parseInt(this.form["competition_time"]), "yyyy-MM-ddThh:mm")
        }
										
        $.db.del("form");
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				// var form = $.db.get("form");
				// var obj = Object.assign({} ,form ,this.obj);
				// if (obj) {
        //   delete(obj.examine_state)
        //   delete(obj.examine_reply)
				// 	this.obj = $.push(this.obj ,obj);
				// }
				// if (form) {
        //   delete(form.examine_state)
        //   delete(form.examine_reply)
				// 	this.form = $.push(this.form ,form);
				// }

				if(func){
					func(json);
				}
			},

		},
		created() {
					this.get_user_session_athlete_account();
					this.get_list_user_athlete_account();
																												this.get_list_user_referee_account();
												},
	}
</script>

<style>




</style>
