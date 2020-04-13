pipeline {
    agent any
    triggers {
        pollSCM('H/5 * * * *')
    }
    tools {
        maven "MAVEN_LATEST"
    }
    options {
        buildDiscarder(logRotator(numToKeepStr: '5', artifactNumToKeepStr: '1'))
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
                script {
                    echo 'Testing...'
                    sh 'mvn test'
                }
            }
        }
        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                script {
                    echo 'Deploying'
                }
            }
        }
    }
}