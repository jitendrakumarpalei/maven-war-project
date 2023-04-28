pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {
        stage("git") {
            steps {
                git 'https://github.com/chinmaya10000/maven-war-project.git'
            }
        }
        stage("build war") {
            steps {
               sh "mvn package"
            }
        }
        stage("build war") {
            steps {
               sshagent(['deploy_user']) {
                sh "scp ssh -o StrictHostKeyChecking=no target/cloudbots_warproj.war ec2-user@18.191.233.8:/opt/tomcat/webapps"
               }
            }
        }
    }
}
