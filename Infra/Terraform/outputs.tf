output "Jenkins-EC2-ipv4" {
  value = module.ec2.Jenkins_EC2-ip
}

output "PyTest-EC2-ipv4" {
  value = module.ec2.PyTest_EC2-ip
}

output "main_RDS_endpoint" {
  value = module.rds.main_rds-endpoint
}

output "test_RDS_endpoint" {
  value = module.rds.test_rds-endpoint
}