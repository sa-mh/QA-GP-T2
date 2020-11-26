output "main_rds-endpoint" {
  value = aws_db_instance.rds1.endpoint
}
output "test_rds-endpoint" {
  value = aws_db_instance.rds2.endpoint
}