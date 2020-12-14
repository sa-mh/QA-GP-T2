output "Jenkins-IP" {
  value = module.ec2.Jenkins-IP
}

output "Test-IP" {
  value = module.ec2-2.Jenkins-IP
}

output "Main-RDS-Endpoint" {
  value = module.rds.main_rds-endpoint
}

output "Test-RDS-Endpoint" {
  value = module.rds-2.main_rds-endpoint
}