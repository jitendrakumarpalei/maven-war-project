pipeline {

    agent any
    tools {
        maven 'Maven'
    }

    stages {
        stage("build war") {
            steps {
                script {
                    echo "bulding the image"
                    sh 'mvn package'
                }
            }
        }
        stage("building image") {
            steps {
                script {
                    echo "building the docker image"
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t chinmayapradhan/tomcat-app:latest .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push chinmayapradhan/tomcat-app:latest'
                    }
                }
            }
        }
        stage("deploy app") {
            steps {
                script {
                    echo "deploying the app"
                }
            }
        }
    }
}     
