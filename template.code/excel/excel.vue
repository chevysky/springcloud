<template>
    <div>
        <el-upload
        ref="upload"
        :show-file-list="true"
        accept="application/vnd.ms-excel"
        action="http://localhost:8019/user/excel"
        :on-success="fileUploadSuccess"
        :on-error="fileUploadFail"
        :auto-upload="false"
        >
        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" type="success" @click="submitUpload">上传到服务器</el-button>
        </el-upload>
    </div>
</template>

<script>
export default {
    name:'excel',
    methods:{
        fileUploadSuccess(){
            console.log("上传成功");
            //上传成功清除列表
            this.$refs.upload.clearFiles();
        },
        fileUploadFail(){
            console.log("上传失败");
        },
        submitUpload() {
        this.$refs.upload.submit();
        }

    }
}
</script>

