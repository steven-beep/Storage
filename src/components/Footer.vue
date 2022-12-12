<template>
  <el-menu class="el-footer">
    <br>
    ©   •   Powered by 2022 罗念笙
    <br/>
    ICP 浙ICP备2022023105号 ♥ Theme Amaze by steven-beep
  </el-menu>
</template>

<script>

export default {
  name: 'Footer',
  data() {
    return {}
  },
  computed: {
  },
  methods: {
  }
}
</script>

<style lang="stylus" scoped>
.el-footer {
  text-align: center;
  font-family: '华文楷体';
  /*position: absolute;*/
  // 设置页脚position为absolute之后，再将其bottom值设为0，即可使其处于页面的底部
  /*bottom: 0;*/
  /*width: 100%;*/
  background-color: #c6e2ff
  margin-top: -50px;
  height: 86px;
}
</style>