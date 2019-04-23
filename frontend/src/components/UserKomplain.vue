<template>
    <v-app>
        <nav-bar-user></nav-bar-user>

        <v-stepper v-model="e6" vertical>
            <v-stepper-step :complete="e6 > 1" step="1">
                Select an app
                <small>Summarize if needed</small>
            </v-stepper-step>

            <v-stepper-content step="1">
                <v-card color="grey lighten-1" class="mb-5" height="200px"></v-card>
                <v-btn color="primary" @click="e6 = 2">Continue</v-btn>
                <v-btn flat>Cancel</v-btn>
            </v-stepper-content>

            <v-stepper-step :complete="e6 > 2" step="2">Configure analytics for this app</v-stepper-step>

            <v-stepper-content step="2">
                <v-card color="grey lighten-1" class="mb-5" height="200px"></v-card>
                <v-btn color="primary" @click="e6 = 3">Continue</v-btn>
                <v-btn flat>Cancel</v-btn>
            </v-stepper-content>

            <v-stepper-step :complete="e6 > 3" step="3">Select an ad format and name ad unit</v-stepper-step>

            <v-stepper-content step="3">
                <v-card color="grey lighten-1" class="mb-5" height="200px"></v-card>
                <v-btn color="primary" @click="e6 = 4">Continue</v-btn>
                <v-btn flat>Cancel</v-btn>
            </v-stepper-content>

            <v-stepper-step step="4">View setup instructions</v-stepper-step>
            <v-stepper-content step="4">
                <v-card color="grey lighten-1" class="mb-5" height="200px"></v-card>
                <v-btn color="primary" @click="e6 = 1">Continue</v-btn>
                <v-btn flat>Cancel</v-btn>
            </v-stepper-content>
        </v-stepper>

        <nav-footer-user></nav-footer-user>
    </v-app>
</template>

<script>
    import NavBar from './NavBarUser'
    import Footer from './FooterUser'

    export default {
        name: "UserKomplain",
        components:{
            'nav-bar-user': NavBar,
            'nav-footer-user' : Footer
        },
        data () {

        }
    }
</script>

<style scoped>

</style>