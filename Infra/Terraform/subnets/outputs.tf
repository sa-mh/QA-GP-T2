output "subnet_id" {
  value = aws_subnet.VPCSub["eu-west-1a"].id
}
output "subnet2_id" {
  value = aws_subnet.VPCSub["eu-west-1b"].id
}
output "subnet3_id" {
  value = aws_subnet.VPCSub["eu-west-1c"].id
}
output "rds_subnet_grp_id" {
  value = aws_db_subnet_group.rds_groups.id
}
