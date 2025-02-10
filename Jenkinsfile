Share


You said:
pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-token',  // The credentials ID from Jenkins
                    url: 'https://github.com/HabibullahAfzali/image-gallery.git'
            }
        }

        stage('Build Backend (Spring Boot)') {
            steps {
                sh './gradlew build'  // Modify this for your build process
            }
        }

        stage('Build Frontend (React)') {
            steps {
                sh 'npm install && npm run build'
            }
        }

        stage('Run Docker (MySQL)') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }

        stage('Run Tests') {
            steps {
                sh './gradlew test'  // Modify for your test process
            }
        }
    }

    post {
        always {
            echo 'Cleaning up Docker...'
            sh 'docker-compose -f docker-compose.yml down'
        }
    }
}
