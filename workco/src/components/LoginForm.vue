<template>
  <el-form
    ref="ruleFormRef"
    :model="ruleForm"
    :rules="rules"
    label-width="80px"
    class="registerForm"
    :size="formSize"
    status-icon
  >
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="ruleForm.email" />
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="ruleForm.password" />
    </el-form-item>
    <el-form-item>
      <el-button 
      @click="submitForm(ruleFormRef)"
      color="#1F80B0"
      >
      登录
      </el-button>
      <el-button 
      @click="register"
      color="#1F80B0"
      >
      注册
      </el-button>
    </el-form-item>
  </el-form>
</template>
<script lang="ts" setup>
import {reactive, ref} from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { useRouter } from 'vue-router';

const router = useRouter()

const formSize = ref('large')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
    email: '',
    userName: '',
    password: '',
})

const rules = reactive<FormRules>({
    email:[
        { required: true, message: '请输入邮箱', trigger: 'blur' },
       
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' },
    ],
})

const submitForm = async (formEl: FormInstance | undefined) => {
    if (!formEl) return
    await formEl.validate((valid, fields) => {
        if (valid) {
          // 在这里把东西发出去
        console.log('submit!')
        } else {
        console.log('error submit!', fields)
        }
    })
}

const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
}

const register = () => {
      router.push({
        path: 'register'
      })
}

</script>
<style scoped>
.registerForm{
  margin-top: 50px;

}

button{
  width: 100px;
  height: 40px;
  margin-top: 15px;
}
</style>