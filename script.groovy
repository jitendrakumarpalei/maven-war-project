def buildJar() {
    echo "building the application"
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t chinmayapradhan/tomcat-app:lts .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push chinmayapradhan/tomcat-app:lts'
    }
}

def deployApp() {
    echo "deploying the app"
}

return this
