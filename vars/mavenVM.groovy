def call(Map mavenMap) {
    echo "Generic Pipeline called with params: ${javaVMMap}"
    def JENKINS_NODE = 'JENKINC_SLAVE'
    static final String repoName = utils.determineBitBucketRepoName()
    echo "Bitbucket repo name: ${repoName}"
    Map bitBucketPost = [
        'name': 'APPLICATION PIPELINE'
    ];

pipeline {
    agent null

    stages {
        stage('Checkout SCM') {
            echo "Checkout SCM workspace: ${WORKSPACE}, jobUrl: ${JOB_URL}, buildNumber: ${$BUILD_NUMBER}"
        }

    }

    post {
        
        failure {
            echo "Post Action Failure"
        }

        always {
            echo "Post Action Always"
        }
    }
}
}