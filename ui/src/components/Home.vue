<template>
  <div>
    <ul v-for="category in categories">
      <li>{{ category.name }}</li>
    </ul>
  </div>
</template>

<script>

import {categoriesApi} from "../api/categories";

export default {
  name: "Hello",
  data() {
    return {
      categories: Array
    }
  },
  async created() {
    this.categories = await categoriesApi.getInstance().getAllCategories()
  },
}
</script>

<style scoped>

</style>
