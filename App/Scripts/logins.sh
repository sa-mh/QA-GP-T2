#!/bin/bash
docker login -u ${NexusUser} -p ${NexusPassword}
aws configure set aws_access_key_id ${awsKey}
aws configure set aws_secret_access_key ${awsSecretKey}
aws configure set region eu-west-1
aws eks --region eu-west-1 update-kubeconfig --name project_cluster
