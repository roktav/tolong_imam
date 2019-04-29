<template>
    <v-app id="inspire">
        <v-content>
            <v-container fluid fill-height>
                <v-layout align-center justify-center>
                    <v-flex xs12 sm8 md4>
                        <v-card class="elevation-12">
                            <v-toolbar dark color="primary">
                                <v-toolbar-title>Login form</v-toolbar-title>
                                <v-spacer></v-spacer>
                                <v-tooltip bottom>
                                    <v-btn
                                            icon
                                            large
                                            :href="source"
                                            target="_blank"
                                            slot="activator"
                                    >
                                        <v-icon large>code</v-icon>
                                    </v-btn>
                                    <span>Source</span>
                                </v-tooltip>
                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field prepend-icon="person" v-model="username" name="login" label="Login" type="text"></v-text-field>
                                    <v-text-field prepend-icon="lock"  v-model="password" name="password" label="Password" id="password" type="password"></v-text-field>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer></v-spacer>
                                <v-btn color="primary" href="/admin-teknisi/profile">Login</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
    export default {
        data: () => ({
            drawer: null
        }),

        props: {
            source: String
        },
        data:{
            username: '',
            password: '',
        },
        methods: {
            login(){
                var params = new URLSearchParams();
                params.append('grant_type', 'password');
                params.append('login', this.username);
                params.append('password',this.password);
                axios({
                    method:'post',
                    url:'oauth/token',
                    auth:{username:this.password},
                    headers: {"Content-type": "application/x-www-form-urlencoded; charset=utf-8"},
                    data:params
                }).then(function(response){
                    set_cookie("access_token",response.data.access_token);
                    document.location.replace("/");
                });
            }
        }
    }
</script>

<style scoped>
    li {
        list-style: none;
    }

    .navMenu{
        margin-bottom: 0;
    }

    .navMenu li{
        display:inline-block;
    }

    #loginHeader{
        text-align: center;
        padding-top: 2em;
    }

    .align-center{
        float:none;
        margin: 0 auto;
    }

    #loggedIn{
        display:inline;
        float:right;
    }

    .comments {
        margin-left: 20px;
        padding: 25px;
        background: rgba(0, 0, 0, 0.02);
        border-radius: 10px 10px 10px 10px;
    }
</style>
