output "Jenkins-IP" {
  value = module.ec2.Jenkins-IP
}

output "Test-IP" {
  value = module.ec2-2.Jenkins-IP
}

output "Nexus-IP" {
  value = module.ec2-3.Jenkins-IP
}

output "MainRDSEndpoint" {
  value = module.rds.main_rds-endpoint
}

output "TestRDSEndpoint" {
  value = module.rds-2.main_rds-endpoint
}