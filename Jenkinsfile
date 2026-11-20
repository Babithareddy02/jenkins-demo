
pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out Login Automation Project'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Compiling Maven project'
                bat 'mvn clean compile'
            }
        }

        stage('Execute Login Tests') {
            steps {
                echo 'Executing Selenium Login Tests'
                bat 'mvn test -Dheadless=true'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {

        always {
            echo 'Login automation execution completed'
        }

        success {
            echo 'Login automation successful'
        }

        failure {
            echo 'Login automation failed'
        }
    }
}
