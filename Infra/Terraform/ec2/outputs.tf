output "ec2_id" {
  value = aws_instance.demo.id
}
output "Jenkins_EC2-ip" {
  value = aws_instance.demo.public_ip
}

output "PyTest_EC2-ip" {
  value = aws_instance.pyTestEC2.public_ip
}
output "PyTest_EC2_id" {
  value = aws_instance.pyTestEC2.id
}
