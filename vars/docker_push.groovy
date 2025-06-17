def call(String credId, String imageName) {
    withCredentials([usernamePassword(
        credentialsId: credId, 
        passwordVariable: 'PASSWORD', 
        usernameVariable: 'USERNAME'
    )]) {
        sh "docker login -u ${USERNAME} -p ${PASSWORD}"
        sh "docker tag ${imageName} ${USERNAME}/${imageName}"
        sh "docker push ${USERNAME}/${imageName}:latest"
    }
}
