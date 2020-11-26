output "subnet_id" {
  value = aws_subnet.taskVPCSubnet.id
}
output "subnet2_id" {
  value = aws_subnet.rdsSubnet2.id
}
output "subnet3_id" {
  value = aws_subnet.rdsSubnet3.id
}
output "rds_subnet_grp_id" {
  value = aws_db_subnet_group.rds_groups.id
}
