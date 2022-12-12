<template>
  <div id="app">
    <!-- 3. 使用组件 -->
    <Header></Header>
    <router-view />
    <Footer></Footer>
  </div>
</template>

<script>
import Header from '@/components/Header.vue'
import Footer from "./components/Footer"; //  1. 引入组件

export default {
  name: 'App',
  //  2. 注册组件
  components: {
    Footer,
    Header
  }
}
</script>

<style lang="stylus">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}
Header{

}
</style>
