def call(Map mavenMap) {
    echo "Generic Pipeline called with params: ${mavenMap}"
    def gitInfo
    def JENKINS_NODE = 'JENKINC_SLAVE'
    static final String repoName = utils.determineBitBucketRepoName()
    echo "Bitbucket repo name: ${repoName}"
    Map bitBucketPost = [
        'name': 'APPLICATION PIPELINE',
        'url': "${JOB_URL}${BUILD_NUMBER}",
        'commitID': "",
        'repoName': repoName
    ];

pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                echo "Checkout SCM workspace: ${WORKSPACE}, jobUrl: ${JOB_URL}, buildNumber: ${BUILD_NUMBER}"
                script {
                    gitInfo = checkout scm
                    echo gitInfo.toString()
                    sh '''
                        java -version
                        javac -version
                        which mvn
                        mvn --version
                        pwd
                        ls -lrt
                        
                    '''
                }
            }
            
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