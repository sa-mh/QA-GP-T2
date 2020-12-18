variable "ami" {
  description = "machine image"
  default     = "ami-0dc8d444ee2a42d8a"
}

variable "type" {
  description = "machine size"
  default     = "t2.medium"
}

variable "subnet_id" {
  description = "Subnet ID to be overriden"
}

variable "security_group_ids" {
  description = "IDs to be overriden"
}

variable "tag1" {
  description = "Tag name for main ec2"
}

variable "size" {
  description = "VM storage in GB"
  default = 16
}
