<template>
  <router-view/>
  <footer-component/>
</template>

<script>
import Footer from "./components/Footer.vue";

export default {
  components: {
    'footer-component': Footer
  }
}
</script>

<style>

</style>
