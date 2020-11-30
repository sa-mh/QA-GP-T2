output "subnet_id" {
  value = aws_subnet.VPCSub.0.id
}
output "subnet2_id" {
  value = aws_subnet.VPCSub.1.id
}
output "subnet3_id" {
  value = aws_subnet.VPCSub.2.id
}
output "rds_subnet_grp_id" {
  value = aws_db_subnet_group.rds_groups.id
}
