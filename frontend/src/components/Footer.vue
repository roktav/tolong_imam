<template>
    <v-footer app absolute="fixed" :clipped-left="true" dark class="primary">
      <span class="caption mx-3">Copyright &copy; 2019 Wirelessindo | Total IT Solution</span>
    </v-footer>    
</template>

<script>
export default {
    data(){
        absolute: "true"
    },
    props: ['fixed']
}
</script>

<style>

</style>
