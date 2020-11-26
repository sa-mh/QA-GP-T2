variable "ami" {
  description = "machine image"
  default     = "ami-0dc8d444ee2a42d8a"
}

variable "type" {
  description = "machine size"
  default     = "t2.small"
}

variable "ami-ROI" {
  description = "machine image"
  default     = "ami-0dc8d444ee2a42d8a"
}
variable "ROIzone" {
  description = "machine image"
  default     = "eu-west-1a"
}
variable "zone" {
  description = "map of availability zones for eu-west-1"
  default = {
    1 = "eu-west-1a"
    2 = "eu-west-1b"
    3 = "eu-west-1c"
  }
}
variable "subnet_id" {
  description = "subnet ID to be overriden"
}
variable "security_group_ids" {
  description = "IDs to be overriden"
}