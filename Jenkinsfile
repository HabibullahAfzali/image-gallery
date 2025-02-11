pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-token',  // GitHub token ID for pulling repo
                    url: 'https://github.com/HabibullahAfzali/image-gallery.git'
            }
        }

        stage('Build Backend (Spring Boot)') {
            steps {
                sh './gradlew build'  // Modify this for your backend build process
            }
        }

        stage('Build Frontend (React)') {
            steps {
                sh 'npm install && npm run build'
            }
        }

        stage('Login to Docker Hub') {
            steps {
                withCredentials([string(credentialsId: 'docker-hub-secret', variable: 'DOCKER_TOKEN')]) {
                    // Use your Docker Hub token to login
                    sh 'docker login -u habibafzali -p $DOCKER_TOKEN'
                }
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
