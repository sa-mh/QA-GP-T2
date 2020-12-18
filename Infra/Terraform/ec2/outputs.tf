output "vm1-id" {
  value = aws_instance.EC2.id
}

output "Jenkins-IP" {
  value = aws_instance.EC2.public_ip
}

