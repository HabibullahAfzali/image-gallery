pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS = credentials('docker-hub-credentials')  // Jenkins credential for Docker Hub (optional if pushing)
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'github-token', url: 'https://github.com/HabibullahAfzali/image-gallery.git'
            }
        }

        stage('Build Backend (Spring Boot)') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Frontend (React)') {
            steps {
                dir('frontend') { // Ensure you're in the frontend directory
                    sh 'npm install && npm run build'
                }
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    sh 'docker build -t image-gallery-backend ./backend'
                    sh 'docker build -t image-gallery-frontend ./frontend'
                }
            }
        }

        stage('Run MySQL') {
            steps {
                sh 'docker-compose -f docker-compose.yml up -d mysql'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy Containers') {
            steps {
                script {
                    sh 'docker run -d --name image-gallery-backend --network app-network -p 8081:8081 image-gallery-backend'
                    sh 'docker run -d --name image-gallery-frontend --network app-network -p 80:80 image-gallery-frontend'
                }
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
